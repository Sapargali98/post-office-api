package kz.dar.academy.backend.controller;
import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.model.PostDo;
import kz.dar.academy.backend.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/office")

public class PostOfficeController {
    @Autowired
    private PostFeign postFeign;
    @Autowired
    private ClientFeign clientFeign;
    @GetMapping("/check")
    public String checkPostOffice() {
        return "office-core-api is working";}
    @GetMapping("/post/check")
    public String checkPost() {
        return postFeign.checkPost();}
    @GetMapping("/post/all")
    public List<PostDo> getAllPosts() {
        return postFeign.getAllPosts();}
    @GetMapping("/post/{postId}")
    public PostDo getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);}
    @GetMapping("/client/check")
    public String checkClients() {
        return clientFeign.checkClient();}
    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients() {
        return clientFeign.getAllClients();}
    @GetMapping("/client/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);}
    @GetMapping("/client/info")
        public List<PostResponse> getAllClientsFullInfo() {
        List<PostResponse> result = new ArrayList<>();
        List<PostDo> postList = postFeign.getAllPosts();
        for (PostDo post : postList) {
            String clientId = post.getClientId();
            String postRecipientId = post.getPostRecipientId();
            ClientResponse client = clientFeign.getClientById(clientId);
            ClientResponse recipient = clientFeign.getClientById(postRecipientId);
            PostResponse postResponse = new PostResponse();
            postResponse.setPostId(post.getPostId());
            postResponse.setClient(client);
            postResponse.setReceiver(recipient);
            postResponse.setPostItem(post.getPostItem());
            postResponse.setStatus(post.getStatus());
            result.add(postResponse);
        }
        return result;
    }
}
