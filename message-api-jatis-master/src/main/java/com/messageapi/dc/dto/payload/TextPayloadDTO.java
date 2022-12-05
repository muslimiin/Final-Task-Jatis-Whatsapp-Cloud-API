package com.messageapi.dc.dto.payload;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TextPayloadDTO {
    private Boolean preview_url;

    private String body;
}
