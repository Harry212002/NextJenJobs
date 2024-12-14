package com.harry.springbootrest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.harry.springbootrest.model.JobPost;
import com.harry.springbootrest.service.JobService;

import jakarta.annotation.PostConstruct;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class jobController {
    @Autowired
    private JobService service;


    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();

    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword)
    {
        return service.search(keyword);
    }

//    @GetMapping("load")
//    public String loadData() {
//        service.load();
//        return "success";
//    }
}
