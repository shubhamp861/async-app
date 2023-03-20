package com.sample.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
  class AsyncApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}
	@PostMapping("/createDummy")
	public String getReq(@RequestBody Payload payload){
		System.out.println(payload);
		return "OK";
	}

	@GetMapping("/ping")
	public String ping(){
		return "Ping";
	}

	// inject it,
	@Autowired
	private EnvUtil envUtil;

	/**
	 * env
	 *
	 * @return
	 */
	@GetMapping(path = "/env")
	@ResponseBody
	public Object env() throws UnknownHostException {
		Map<String, Object> map = new HashMap<>();
		map.put("port", envUtil.getPort());
		map.put("host", envUtil.getHostname());
		return map;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(env());
	}
}
class Payload{
	Integer id;
	String name;
	String password;

	public Payload() {
	}

	public Payload(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Payload{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}