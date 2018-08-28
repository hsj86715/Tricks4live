package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;
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
    ICategoryService service;

    @PostMapping("/add")
    @ResponseBody
    public BaseResult addCategory(@RequestParam("name_cn") String nameCN,
                                  @RequestParam("name_en") String nameEN,
                                  @RequestParam(name = "super_id", required = false) Long superId,
                                  @RequestParam(name = "level", defaultValue = "1") Integer level) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(nameCN) || StringUtils.isEmpty(nameEN)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "Category Name(both CN and EN)");
            result.setStatus(Status.FAIL);
            return result;
        }
        Category category = new Category(nameCN, nameEN, superId, level);
        Long id = service.addCategory(category);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/findSubCategory")
    @ResponseBody
    public DataResult<List<Category>> findSubCategory(@RequestParam("cat_id") Long categoryId) {
        List<Category> categories = service.findSubCategory(categoryId);
        DataResult<List<Category>> result = new DataResult<>();
        result.setData(categories);
        return result;
    }

    @RequestMapping("findByLevel")
    @ResponseBody
    public DataResult<List<Category>> findByLevel(@RequestParam("level") Integer level) {
        List<Category> categories = service.findByLevel(level);
        DataResult<List<Category>> result = new DataResult<>(categories);
        return result;
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResult updateCategory(@RequestParam("name_cn") String nameCN, @RequestParam("name_en") String nameEN,
                                     @RequestParam("super_id") Long superId, @RequestParam("cat_id") Long categoryId,
                                     @RequestParam("level") Integer level) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(nameCN) || StringUtils.isEmpty(nameEN) || categoryId == null || categoryId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "Category Name(both CN and EN) and category id");
            result.setStatus(Status.FAIL);
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
        if (categoryId == null || categoryId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "category id");
            result.setStatus(Status.FAIL);
            return result;
        }
        service.deleteById(categoryId);
        return result;
    }
}
