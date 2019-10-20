package jp.personal.gi.pipe_api.adapter.controller.account.register;

import jp.personal.gi.pipe_api.adapter.controller.account.*;
import jp.personal.gi.pipe_api.adapter.logger.*;
import jp.personal.gi.pipe_api.core.usecase.account.register.*;
import jp.personal.gi.pipe_api.core.usecase.account.register.error.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account/register")
@Controller
public class RegisterAccountController {
    private final RegisterAccountInteractor registerAccountInteractor;
    private final Logger logger;

    @Autowired
    public RegisterAccountController(RegisterAccountInteractor registerAccountInteractor, Logger logger) {
        this.registerAccountInteractor = registerAccountInteractor;
        this.logger = logger;
    }

    @RequestMapping(value = "/{name}/{nameReading}/{authority}", method = {RequestMethod.GET})
    @ResponseBody
    public Account apply(@PathVariable String name, @PathVariable String nameReading, @PathVariable Integer authority) {
        try {
            final OutputData outputData = this.registerAccountInteractor.handle(new InputDataAdapter(name, nameReading, authority));
            return new Account(outputData.getAccountId, outputData.getName, outputData.getNameReading, outputData.getAuthority);
        } catch (RegisterException e) {
            this.logger.fatal(e.getMessage());
            return null;
        }
    }
}
