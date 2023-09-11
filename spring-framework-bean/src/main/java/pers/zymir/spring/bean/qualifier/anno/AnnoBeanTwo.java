package pers.zymir.spring.bean.qualifier.anno;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("two")
public class AnnoBeanTwo implements AnnoQualifierBean {

}
