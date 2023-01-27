package cubox.aero.connect.controller;

import cubox.aero.connect.util.ApiUtil;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/landing"})
@CrossOrigin({"origins=*"})
@RestController
public class RestLandingController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/confirmCst"})
    public JSONObject login(
            @RequestParam("customerName") String customerName,
            @RequestParam("companyRegistration") String companyRegistration,
            @RequestParam("managerEmail") String managerEmail,
            @RequestParam("managerName") String managerName,
            @RequestParam("managerPosition") String managerPosition,
            @RequestParam("managerContactNumber") String managerContactNumber,
            @RequestParam("remark") String remark
    ) {

        logger.info("customerName : {}", customerName);
        logger.info("companyRegistration : {}", companyRegistration);
        logger.info("managerEmail : {}", managerEmail);
        logger.info("managerName : {}", managerName);
        logger.info("managerPosition : {}", managerPosition);
        logger.info("managerContactNumber : {}", managerContactNumber);
        logger.info("remark : {}", remark);

        JSONObject cstJson = new JSONObject();
        cstJson.put("customerName", customerName);
        cstJson.put("companyRegistration", companyRegistration);
        cstJson.put("managerEmail", managerEmail);
        cstJson.put("managerName", managerName);
        cstJson.put("managerPosition", managerPosition);
        cstJson.put("managerContactNumber", managerContactNumber);
        cstJson.put("remark", remark);

        ApiUtil apiUtil = new ApiUtil();
        JSONObject reqResult = apiUtil.getApiReq(cstJson.toJSONString(), "/api/v1/addCustomer");

        return reqResult;
    }
}
