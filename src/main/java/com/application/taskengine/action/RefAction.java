package com.application.taskengine.action;

import cheng.lib.lang.PageVO;
import com.application.taskengine.action.BusinessCommonAction;
import com.application.taskengine.model.TaskDeployModel;
import com.application.taskengine.model.TaskPluginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cheng on 2015/8/14.
 */
@Controller
public class RefAction extends BusinessCommonAction {
	@RequestMapping("/management/uicomponent/ref/index")
	public String index(HttpServletRequest request, HttpServletResponse response,PageVO pageVO, Model model) throws Exception {
		String reftype = request.getParameter("reftype");
		String itemkey = request.getParameter("itemkey");
		model.addAttribute("itemkey",itemkey);
		if("taskplugin".equals(reftype)){
			List<TaskPluginModel> data = dataBaseService.queryByClause(TaskPluginModel.class,"dr=0");
			model.addAttribute(DATA,data);
			return "management/uicomponent/ref/index_plugin";
		}
		if("taskdeploy".equals(reftype)){
			List<TaskDeployModel> data = dataBaseService.queryByClause(TaskDeployModel.class,"dr=0");
			model.addAttribute(DATA,data);
			return "management/uicomponent/ref/index_deploy";
		}
		return "management/uicomponent/ref/index";
	}
}