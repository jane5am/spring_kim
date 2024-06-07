package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 가입
    public Long join(Member member) {

        // 같은 이름을 가진 회원의 중복 가입은 안된다고 가정
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // b아래 코드와 같은 코드
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        //        Optional<Member> result = memberRepository.findByName(member.getName());
        //        result.ifPresent( m -> {
        //            throw new IllegalStateException("이미 존재하는 회원입니다.");
        //        }); // result값이 있으면 즉 m(member)에 값이 있으면 에러 반환 , null이 아닐 경우 에러 반환
    }

    // 전체 회원 조회
    public List<Member> findMember() {
        return memberRepository.finaAll();
    }

    // 회원 한명 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
