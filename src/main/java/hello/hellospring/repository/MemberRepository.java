package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 회원 저장
    Member save(Member member);

    // ID찾기
    Optional<Member> findById(Long id); // findById, findByName 동작할때 null 이 있으면 null이 반환되겠지
                                        //null을 그대로 반환하는 대신 Optional로 감싸서 반환하는것
    // 이름찾기
    Optional<Member> findByName(String name);

    // 모든 데이터 반환
    List<Member> finaAll();
}
