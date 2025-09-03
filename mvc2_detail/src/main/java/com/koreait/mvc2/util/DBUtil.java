package com.koreait.mvc2.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static DataSource ds;
    //정적 필드 ds를 선언함
    //데이터베이스 연결 풀 객체인 DataSource를 저장할 용도
    //한 번만 생성되어 클래스 전체에서 공유된다. (static)

    static {
    // 정적 초기화 블록. 클래스가 처음 로딩될 때 단 한 번 실행됨. 여기서 ds를 초기화함.
        try{
            Context ctx = new InitialContext();
            //JNDI 초기 컨텍스트 객체 생성.
            //톰캣 등의 WAS에서 리소스를 찾기 위한 기본 시작점. ex)java:comp/env/jdbc/mydb 같은 리소스를 찾기 시작함.
            Context env = (Context) ctx.lookup("java:comp/env");
            //java:comp/env는 톰캣에서 관리하는 환경 변수 영역 (여기에 내가 등록한 DB리소스가 들어있다.)
            //이 안에 설정된 리소스를 찾기 위해 다시 lookup 수행
            ds = (DataSource) env.lookup("jdbc/mydb");  //context.xml의 name
            //JNDI로 jdbc/mydb라는 이름의 DB 연결 풀을 찾아 ds에 저장
            //→ 즉, 커넥션 풀 설정을 불러오는 부분
        }catch(NamingException e){
            e.printStackTrace();
        }
    }

    // DB 연결을 외부에 제공
    public static Connection getConnection() throws SQLException {
        //외부에서 호출 가능한 정적 메서드.
        return ds.getConnection();
        //→ DataSource를 통해 커넥션 풀에서 하나의 DB 연결을 가져옵니다.
        //→ 예: 커넥션 풀에 20개가 있다면 그 중 하나를 사용하게 됩니다.
    }
}

//context.xml에 설정된 DB 커넥션 풀을 가져와서, 다른 클래스에서 쉽게 DB 연결을 사용할 수 있게 도와주는 JNDI 기반 유틸리티 클래스