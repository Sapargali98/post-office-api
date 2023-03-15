package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private String postId;
    private ClientResponse client;
    private ClientResponse receiver;
    private String postItem;
    private String status;
}
