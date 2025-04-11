import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSP<K, V> {
    private List<K> variables;

    private Map<K, List<V>> domains;

    private Constraint<K, V> constraint;

    public CSP(List<K> variables, 
            Map<K, List<V>> domains, 
            Constraint<K, V> constraint) {
        this.variables = variables;
        this.domains = domains;
        this.constraint = constraint;
    }

    public Map<K, V> solve() {
        return solve(new HashMap<K, V>());
    }

    private Map<K, V> solve(Map<K, V> assignment) {
        if (assignment.size() == this.variables.size()) {
            return assignment;
        }

        List<K> unassigned = new ArrayList<>();
        for (K key:variables) {
            if (!assignment.containsKey(key)) {
                unassigned.add(key);
            }
        }

        K testVariable = unassigned.get(0);

        for (V value:this.domains.get(testVariable)) {
            Map<K, V> testAssignment = new HashMap<>(assignment);
            testAssignment.put(testVariable, value);

            if (this.constraint.check(testAssignment)) {
                Map<K, V> result = solve(testAssignment);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

}
