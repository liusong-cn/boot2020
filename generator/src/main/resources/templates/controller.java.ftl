package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.lang.String;
import ${package.Entity}.${table.entityName};
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.ApiOperation;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    public ${table.serviceName} ${table.entityName}Service;


    @ApiOperation("${table.entityName}-列表")
    @GetMapping(value = "/list")
    public List<${table.entityName}> queryList(@RequestParam("searchVal")String searchVal){
        return ${table.entityName}Service.queryList(searchVal);
    }


}
</#if>
