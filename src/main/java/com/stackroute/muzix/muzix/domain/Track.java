package com.stackroute.muzix.muzix.domain;

import lombok.*;
//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;


//@Document(collection = "Tracks")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Track {
   @Id
    private int trackId;
    private String trackName;
    private String trackComment;
}
