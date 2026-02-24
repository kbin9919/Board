package com.login.chain;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LoginChainFactory {
    // Todo 익셉션 분리하기
    public List<LoginChain> validators() {
        return List.of(
                this::validateId,
                this::validatePwd
        );
    }

    private void validateId(LoginChainContext context) {
        if (!context.inputId.equals(context.realId)) {
            throw new RuntimeException();
        }
    }

    private void validatePwd(LoginChainContext context) {
        if (!context.inputPwd.equals(context.realPwd)) {
            throw new RuntimeException();
        }
    }
}
