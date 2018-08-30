package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.entries.Label;
import com.tricks4live.entries.result.BaseResult;
import com.tricks4live.entries.result.DataResult;
import com.tricks4live.services.ILabelService;
import com.tricks4live.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/label")
public class LabelController {
    @Autowired
    ILabelService service;

    @PostMapping("/add")
    @ResponseBody
    public BaseResult addLabel(@RequestParam("name_cn") String nameCN,
                               @RequestParam("name_en") String nameEN) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(nameCN) || StringUtils.isEmpty(nameEN)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "name_cn or/and name_en");
            return result;
        }
        Label label = new Label(nameCN, nameEN);
        Long id = service.addLabel(label);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
        }
        return result;
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResult updateLabel(@RequestParam("name_cn") String nameCN,
                                  @RequestParam("name_en") String nameEN,
                                  @RequestParam("label_id") Long labelId) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(nameCN) || StringUtils.isEmpty(nameEN)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "name_cn or/and name_en");
            return result;
        }
        if (labelId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "label_id");
            return result;
        }
        Label label = new Label(nameCN, nameEN);
        label.setId(labelId);
        service.updateLabel(label);
        return result;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public DataResult<List<Label>> findAll() {
        List<Label> labelList = service.findAll();
        return new DataResult<>(labelList);
    }
}
