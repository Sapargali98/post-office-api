package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDo {
    private String postId;
    private String clientId;
    private String postRecipientId;
    private String postItem;
    private String status;
}
