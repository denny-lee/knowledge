package com.infosys.knowledge.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.knowledge.dao.FaqMapper;
import com.infosys.knowledge.dao.FrameNoticeMapper;
import com.infosys.knowledge.dao.NotionMapper;
import com.infosys.knowledge.dao.SnippetMapper;
import com.infosys.knowledge.model.Faq;
import com.infosys.knowledge.model.FrameNotice;
import com.infosys.knowledge.model.Notion;
import com.infosys.knowledge.model.Snippet;

@RestController
public class KnowledgeController {
	
	private static final Logger log = LoggerFactory.getLogger(KnowledgeController.class);

    @Autowired
    private SnippetMapper snippetMapper;
    @Autowired
    private FaqMapper faqMapper;
    @Autowired
    private NotionMapper notionMapper;
    @Autowired
    private FrameNoticeMapper frameMapper;

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
    	
    	try {
    		snippetMapper.save(snippet);
    		result.put("success", true);
    	} catch(DataIntegrityViolationException dve) {
    		result.put("success", false);
    		log.error("save snippet时字段过长：" + dve.getMessage());
    	}
    	
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
    		List<Snippet> snippets = snippetMapper.searchByTag(tagParam);
    		resultSet.addAll(snippets);
    	} else {
    		String[] tagArray = tagParam.split(",");
        	for(String t : tagArray) {
        		if(StringUtils.isEmpty(t)) {
        			continue;
        		}
        		List<Snippet> snippets = snippetMapper.searchByTag(tagParam);
        		resultSet.addAll(snippets);
        	}
    	}
    	
        return resultSet;
    }
    
    
    @RequestMapping(method=RequestMethod.POST, value="/saveFaq")
    public Map<String, Object> saveFaq(Faq faq) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(StringUtils.isEmpty(faq.getAnswer())) {
    		faq.setAnswer("待解答");
    	}
    	if(null == faq || StringUtils.isEmpty(faq.getQuestion())) {
    		return null;
    	}
    	
    	String tag = faq.getTag();
    	if(!StringUtils.isEmpty(tag)) {
    		tag = tag.replaceAll("\\s+", ",").replaceAll("，", ",");
        	faq.setTag(tag);
    	}
    	
    	try {
    		faqMapper.save(faq);
    		result.put("success", true);
    	} catch(DataIntegrityViolationException dve) {
    		result.put("success", false);
    		log.error("save faq时字段过长：" + dve.getMessage());
    	}
    	
        return result;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/searchFaq")
    public Set<Faq> searchFaq(String tag) {
    	String tagParam = "";
    	if(!StringUtils.isEmpty(tag)) {
    		tagParam = tag.replaceAll("\\s+", ",").replaceAll("，", ",");;
    	}
    	
    	Set<Faq> resultSet = new HashSet<Faq>();
    	
    	if("".equals(tagParam)) {
    		List<Faq> faq = faqMapper.searchByTag(tagParam);
    		resultSet.addAll(faq);
    	} else {
    		String[] tagArray = tagParam.split(",");
        	for(String t : tagArray) {
        		if(StringUtils.isEmpty(t)) {
        			continue;
        		}
        		List<Faq> faq = faqMapper.searchByTag(tagParam);
        		resultSet.addAll(faq);
        	}
    	}
    	
        return resultSet;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/saveNotion")
    public Map<String, Object> saveNotion(Notion notion) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(null == notion || StringUtils.isEmpty(notion.getLabel()) || StringUtils.isEmpty(notion.getExplain())) {
    		return null;
    	}
    	
    	String tag = notion.getTag();
    	if(!StringUtils.isEmpty(tag)) {
    		tag = tag.replaceAll("\\s+", ",").replaceAll("，", ",");
    		notion.setTag(tag);
    	}
    	
    	try {
    		notionMapper.save(notion);
    		result.put("success", true);
    	} catch(DataIntegrityViolationException dve) {
    		result.put("success", false);
    		log.error("save notion时字段过长：" + dve.getMessage());
    	}
    	
        return result;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/searchNotion")
    public Set<Notion> searchNotion(String tag) {
    	String tagParam = "";
    	if(!StringUtils.isEmpty(tag)) {
    		tagParam = tag.replaceAll("\\s+", ",").replaceAll("，", ",");;
    	}
    	
    	Set<Notion> resultSet = new HashSet<Notion>();
    	
    	if("".equals(tagParam)) {
    		List<Notion> notion = notionMapper.searchByTag(tagParam);
    		resultSet.addAll(notion);
    	} else {
    		String[] tagArray = tagParam.split(",");
        	for(String t : tagArray) {
        		if(StringUtils.isEmpty(t)) {
        			continue;
        		}
        		List<Notion> notion = notionMapper.searchByTag(tagParam);
        		resultSet.addAll(notion);
        	}
    	}
    	
        return resultSet;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/saveNotice")
    public Map<String, Object> saveNotice(FrameNotice notice) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(null == notice || StringUtils.isEmpty(notice.getName()) || StringUtils.isEmpty(notice.getCaution())) {
    		return null;
    	}
    	
    	String tag = notice.getTag();
    	if(!StringUtils.isEmpty(tag)) {
    		tag = tag.replaceAll("\\s+", ",").replaceAll("，", ",");
    		notice.setTag(tag);
    	}
    	
    	try {
    		frameMapper.save(notice);
    		result.put("success", true);
    	} catch(DataIntegrityViolationException dve) {
    		result.put("success", false);
    		log.error("save frame notice 时字段过长：" + dve.getMessage());
    	}
    	
        return result;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/searchNotice")
    public Set<FrameNotice> searchNotice(String tag) {
    	String tagParam = "";
    	if(!StringUtils.isEmpty(tag)) {
    		tagParam = tag.replaceAll("\\s+", ",").replaceAll("，", ",");;
    	}
    	
    	Set<FrameNotice> resultSet = new HashSet<FrameNotice>();
    	
    	if("".equals(tagParam)) {
    		List<FrameNotice> notice = frameMapper.searchByTag(tagParam);
    		resultSet.addAll(notice);
    	} else {
    		String[] tagArray = tagParam.split(",");
        	for(String t : tagArray) {
        		if(StringUtils.isEmpty(t)) {
        			continue;
        		}
        		List<FrameNotice> notice = frameMapper.searchByTag(tagParam);
        		resultSet.addAll(notice);
        	}
    	}
    	
        return resultSet;
    }
}
