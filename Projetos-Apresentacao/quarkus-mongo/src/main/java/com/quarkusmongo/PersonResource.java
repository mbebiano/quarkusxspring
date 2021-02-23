package com.quarkusmongo;

import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/persons")
public class PersonResource {
    @PostMapping
    public Response salvarPerson(@RequestBody Person person){
        person.persist();
        return Response.status(201).build();
    }

}
