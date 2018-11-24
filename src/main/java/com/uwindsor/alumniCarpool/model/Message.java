package com.uwindsor.alumniCarpool.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;


@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String type;
    private String msgContent;
    private Date time;
    private boolean unread;
    private User sender;


    public Message(){
    }

}
