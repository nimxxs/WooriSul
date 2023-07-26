package hanjan.yeji.boot.woorisul.model;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cocktail {
    private String cno;
    private String cname;
    private String mix;
    private String comment;
    private String thumbs;
    private String recipe;
    private String base;
    private String cphoto;


    private CocAttach ca;
}
