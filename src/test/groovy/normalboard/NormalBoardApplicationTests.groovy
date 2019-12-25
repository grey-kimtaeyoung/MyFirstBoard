package normalboard;

import spock.lang.Specification;

class NormalBoardApplicationTests extends Specification {
    def "temporary test"() {
        given:
        List<Integer> list = new ArrayList<>()
        when:
        list.add(1)
        then:
        2 == list.get(0)
    }

    def "temporary second test"() {
        given:
        List<Integer> list = new ArrayList<>()
        when:
        list.add(1)
        then:
        1 == list.get(0)
    }
}
