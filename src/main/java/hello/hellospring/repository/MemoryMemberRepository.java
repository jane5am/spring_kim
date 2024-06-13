package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        // store.values().steam() : store를 루프 돌리는것
        // .filter(member -> member.getName().equals(name)).findAny();
        // 멤버에서 member.getname이 파라미터로 넘어온 name과 같은지 확인한다.
        // 같은 경우만 필터링이 되고 그 중에서 값을 찾으면
        // findAny() : 루프돌면서 값을 하나라도 찾으면 그 찾은거 반환한다
        // 그런데 끝까지 돌렸는데도 없으면 Optional에 null이 포함되어 반환된다

    }

    @Override
    public List<Member> finaAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
