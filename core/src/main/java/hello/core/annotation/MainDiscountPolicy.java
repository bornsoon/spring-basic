package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// @Qaulifier 에서 가져옴
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
// @Qaulifier 에서 가져옴
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {

}
