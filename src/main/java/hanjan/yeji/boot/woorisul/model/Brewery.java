package hanjan.yeji.boot.woorisul.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brewery {
    private String bno;
    private String brname;
    private String addr;
    private String bkind;
    private String tel;
    private String waddr;
    private String swo;
    private String pno;
    private String bphoto;
    private String district;
    private String views;

    private Program pr;
    private SulBoard sul;
}
