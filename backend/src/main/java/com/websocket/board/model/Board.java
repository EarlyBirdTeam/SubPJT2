package com.websocket.board.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Board {

    public enum BoardModuleType {
        POST_IT, CALENDAR, CANVAS;
    }

    // 멤버, 부착물 관련 인자
    private final int MAX_FIXTURES = 100; // 최대 부착물 갯수
    private final int MAX_MEMBERS = 100; // 최대 멤버 수
    private long numOfMembers; // 멤버 수
    private long numOfFixtures; //부착물 갯수
    private boolean overMaxMembers; // 최대 멤버 수를 넘었는지
    private boolean overMaxFixtures; // 최대 부착물 수를 넘었는지

    // 기능 관련 인자
    private List<Postit> postitList; // 포스트잇 리스트
    // List<Calendar> calendarList; // 캘린더 리스트
    // List<Canvas> canvas; // 캔버스 리스트
    // List<Map> mapList; // 맵 리스트
    // List<Attendance> attendenceList; // 출석부 리스트
    // List<Attendance> voteList; // 출석부 리스트

    // 라이브채팅, 화상채팅
    private boolean liveChat; // 라이브챗 켜져있는지
    private boolean videoChat; // 화상채팅 켜져있는지

    @Builder
    public Board(){
        this.numOfMembers = 0;
        this.numOfFixtures = 0;
        this.overMaxMembers = false;
        this.overMaxFixtures = false;
        this.postitList = new ArrayList<Postit>();
        this.liveChat = false;
        this.videoChat = false;
    }
}
