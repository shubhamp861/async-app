package com.async;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
class AsyncApplication implements CommandLineRunner {
	@Autowired
	private EnvUtil envUtil;

	AsyncApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

	@PostMapping({"/createDummy"})
	public Payload getReq(@RequestBody Payload payload) {
		System.out.println(payload);
		payload.setId(9999);
		return payload;
	}

	@GetMapping({"/ping"})
	public String ping() {
		return "Ping";
	}

	@GetMapping(
			path = {"/env"}
	)
	@ResponseBody
	public Object env() throws UnknownHostException {
		Map<String, Object> map = new HashMap();
		map.put("port", this.envUtil.getPort());
		map.put("host", this.envUtil.getHostname());
		return map;
	}

	public void run(String... args) throws Exception {
		System.out.println(this.env());
	}
}

