package jp.personal.gi.pipe_api.adapter.controller.account.find;

import jp.personal.gi.pipe_api.adapter.controller.account.*;
import jp.personal.gi.pipe_api.adapter.logger.*;
import jp.personal.gi.pipe_api.core.usecase.account.find.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account/find")
@Controller
public class FindAccountController {
    private final FindAccountInteractor findAccountInteractor;
    private final Logger logger;

    @Autowired
    public FindAccountController(FindAccountInteractor findAccountInteractor, Logger logger) {
        this.findAccountInteractor = findAccountInteractor;
        this.logger = logger;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Account apply(@PathVariable String id) {
        try {
            final OutputData outputData = this.findAccountInteractor.handle(id);
            return new Account(outputData.getAccountId, outputData.getName, outputData.getNameReading, outputData.getAuthority);
        } catch (FindException e) {
            this.logger.fatal(e.getMessage());
            return null;
        }
    }
}
