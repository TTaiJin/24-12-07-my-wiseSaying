package com.ll;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Command {
    private final String actionName;
    private final Map<String, String> actionMap;
    public Command(String cmd) {
        this.actionMap = new HashMap<>();
        String[] cmdBits = cmd.trim().split("\\?", 2); // 삭제?id=1
        actionName = cmdBits[0];

        if(cmdBits.length == 1) return; // 종료, 등록, 목록

        String[] queryBits = cmdBits[1].trim().split("&"); // 목록?keywordType=content&keyword=과거

        for (String str : queryBits) { // id=1
            String[] strSplit = str.trim().split("=");
            String key = strSplit[0];
            String value = strSplit[1];
            actionMap.put(key, value);
        }
    }
    public int getActionMapValueAsInt(String id) {
        return Integer.parseInt(actionMap.get(id));
    }
}
