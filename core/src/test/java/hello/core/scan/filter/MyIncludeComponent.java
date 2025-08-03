package hello.core.scan.filter;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface MyIncludeComponent { // 이 어노테이션이 붙으면 component에 추가

}
