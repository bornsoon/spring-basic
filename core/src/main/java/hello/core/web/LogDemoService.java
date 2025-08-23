package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    // Provider 미사용시 오류: Scope 'request' is not active for the current thread;
    private final MyLogger myLogger;  // Proxy 모드로 바로 사용 가능해짐!
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
