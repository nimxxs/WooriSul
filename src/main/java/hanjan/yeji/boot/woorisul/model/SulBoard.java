package hanjan.yeji.boot.woorisul.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SulBoard {
  private String sno;
  private String sname;
  private String kind;
  private String base;
  private String ptg;
  private String intro;
  private String bno;
  private String tag;
  private String sphoto;

  private Brewery br;
}
