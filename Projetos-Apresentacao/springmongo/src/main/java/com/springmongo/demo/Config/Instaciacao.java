package com.springmongo.demo.Config;

import com.springmongo.demo.domain.Post;
import com.springmongo.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postReposiroty;

    @Autowired
    Environment environment;

    @Value("${server.port}")
    int aPort;

    @Override
    public void run(String... args) throws Exception {

        Post post = new Post("1", "Teste post", "Mongo Instaciação");
        postReposiroty.save(post);
        System.out.println("Salvo");
        somePlaceInTheCode();


    }
    public void somePlaceInTheCode() {
        // Port
        environment.getProperty("server.port");
        System.out.println("port: "+environment.getProperty("server.port"));
        // Local address
        try {
            InetAddress.getLocalHost().getHostAddress();
            System.out.println("Local ip: "+InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            InetAddress.getLocalHost().getHostName();
            System.out.println("Local ip: "+InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Remote address
        System.out.println("Remote ip: "+InetAddress.getLoopbackAddress().getHostAddress());
        InetAddress.getLoopbackAddress().getHostAddress();
        System.out.println("Remote HostName: "+InetAddress.getLoopbackAddress().getHostName());
        InetAddress.getLoopbackAddress().getHostName();
    }

}
