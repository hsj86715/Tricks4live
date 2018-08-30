package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.entries.Category;
import com.tricks4live.entries.result.BaseResult;
import com.tricks4live.entries.result.DataResult;
import com.tricks4live.services.ICategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @PostMapping("/add")
    @ResponseBody
    public BaseResult addCategory(@RequestParam("name_cn") String nameCN,
                                  @RequestParam("name_en") String nameEN,
                                  @RequestParam(name = "super_id", required = false) Long superId,
                                  @RequestParam("level") Integer level) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(nameCN) || StringUtils.isEmpty(nameEN)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "name_cn or/and name_en");
            return result;
        }
        if (superId != null && superId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "super_id");
            return result;
        }
        Category category = new Category(nameCN, nameEN, superId, level);
        Long id = service.addCategory(category);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
        }
        return result;
    }

    @RequestMapping("/findSubCategory")
    @ResponseBody
    public DataResult<List<Category>> findSubCategory(@RequestParam("cat_id") Long categoryId) {
        DataResult<List<Category>> result = new DataResult<>();
        if (categoryId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "cat_id");
            return result;
        }
        List<Category> categories = service.findSubCategory(categoryId);
        result.setData(categories);
        return result;
    }

    @RequestMapping("findByLevel")
    @ResponseBody
    public DataResult<List<Category>> findByLevel(@RequestParam("level") Integer level) {
        DataResult<List<Category>> result = new DataResult<>();
        if (level <= 0 || level > 3) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "level");
            return result;
        }
        List<Category> categories = service.findByLevel(level);
        result.setData(categories);
        return result;
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResult updateCategory(@RequestParam("name_cn") String nameCN,
                                     @RequestParam("name_en") String nameEN,
                                     @RequestParam(name = "super_id", required = false) Long superId,
                                     @RequestParam("cat_id") Long categoryId,
                                     @RequestParam("level") Integer level) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(nameCN) || StringUtils.isEmpty(nameEN)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "name_cn or/and name_en");
            return result;
        }
        if ((superId != null && superId <= 0) || categoryId <= 0 || level <= 0 || level > 3) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "super_id or/and cat_id or/and level");
            return result;
        }
        Category category = new Category(nameCN, nameEN, superId, level);
        category.setId(categoryId);
        service.updateCategory(category);
        return result;
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public BaseResult deleteById(@RequestParam("cat_id") Long categoryId) {
        BaseResult result = new BaseResult();
        if (categoryId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "cat_id");
            return result;
        }
        service.deleteById(categoryId);
        return result;
    }
}
