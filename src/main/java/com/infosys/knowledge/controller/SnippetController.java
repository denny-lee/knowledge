package com.infosys.knowledge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.knowledge.dao.SnippetMapper;
import com.infosys.knowledge.model.Snippet;

@RestController
public class SnippetController {

    @Autowired
    private SnippetMapper mapper;

    @RequestMapping(method=RequestMethod.POST, value="/saveSnippet")
    public Map<String, Object> saveSnippet(Snippet snippet) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(null == snippet || StringUtils.isEmpty(snippet.getTag()) || StringUtils.isEmpty(snippet.getContent())) {
    		return null;
    	}
    	
    	mapper.save(snippet);
    	result.put("success", true);
    	
        return result;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/searchSnippet")
    public List<Snippet> searchSnippet(String tag) {
    	if(StringUtils.isEmpty(tag)) {
    		return null;
    	}
    	
    	List<Snippet> snippets = mapper.searchByTag(tag);
    	
        return snippets;
    }
}
