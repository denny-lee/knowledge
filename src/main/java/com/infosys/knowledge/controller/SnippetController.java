package com.infosys.knowledge.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    	
    	String tag = snippet.getTag();
    	String language = snippet.getLanguage();
    	tag = tag.replaceAll("\\s+", ",").replaceAll("，", ",");
    	snippet.setTag(tag);
    	if(!StringUtils.isEmpty(language)) {
    		language = language.replaceAll("\\s+", ",").replaceAll("，", ",");
    		snippet.setLanguage(language);
    	}
    	
    	mapper.save(snippet);
    	result.put("success", true);
    	
        return result;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/searchSnippet")
    public Set<Snippet> searchSnippet(String tag) {
    	String tagParam = "";
    	if(!StringUtils.isEmpty(tag)) {
    		tagParam = tag.replaceAll("\\s+", ",").replaceAll("，", ",");;
    	}
    	
    	Set<Snippet> resultSet = new HashSet<Snippet>();
    	
    	if("".equals(tagParam)) {
    		List<Snippet> snippets = mapper.searchByTag(tagParam);
    		resultSet.addAll(snippets);
    	} else {
    		String[] tagArray = tagParam.split(",");
        	for(String t : tagArray) {
        		if(StringUtils.isEmpty(t)) {
        			continue;
        		}
        		List<Snippet> snippets = mapper.searchByTag(tagParam);
        		resultSet.addAll(snippets);
        	}
    	}
    	
        return resultSet;
    }
}
