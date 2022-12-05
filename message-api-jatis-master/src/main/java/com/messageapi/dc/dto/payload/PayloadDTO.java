package com.messageapi.dc.dto.payload;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayloadDTO {

    private String messaging_product;

    private String recipient_type;

    private String to;

    private String type;

    private TextPayloadDTO text;

}
