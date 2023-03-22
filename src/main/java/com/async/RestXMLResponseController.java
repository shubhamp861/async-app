package com.async;

// Java Program Illustrating REST API returning XML response



// Importing required classes
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotations
@RestController
@RequestMapping(path = "/rest",
        produces = "application/xml")

// Class
public class RestXMLResponseController {

    @GetMapping("/get")
    public ResponseEntity<EntityModel> get()
    {

        EntityModel model = new EntityModel();
        model.setID("1");
        model.setNAME("Darshan.G.Pawar");
        model.setDOB("05-09-2001");
        model.setPINCODE("422 009");

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<EntityModel> entityModel
                = new ResponseEntity<>(model, headers,
                HttpStatus.CREATED);

        return entityModel;
    }

    // Annotation
    @GetMapping("/get/{id}")

    // Class
    public ResponseEntity<EntityModel>
    getById(@PathVariable("id") String id)
    {

        EntityModel model = new EntityModel();
        model.setID(id);
        model.setNAME("Darshan.G.Pawar");
        model.setDOB("05-09-2001");
        model.setPINCODE("422 009");

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<EntityModel> entityModel
                = new ResponseEntity<>(model, headers,
                HttpStatus.CREATED);

        return entityModel;
    }
}

