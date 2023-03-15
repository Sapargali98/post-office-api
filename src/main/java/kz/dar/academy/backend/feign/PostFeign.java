package kz.dar.academy.backend.feign;

import kz.dar.academy.backend.model.PostDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("post-core-api")
public interface PostFeign {
    @GetMapping("/post/check")
    String checkPost();
    @GetMapping("/post/all")
    List<PostDo> getAllPosts();
    @GetMapping("/post/{postId}")
    PostDo getPostById(@PathVariable String postId);
}
