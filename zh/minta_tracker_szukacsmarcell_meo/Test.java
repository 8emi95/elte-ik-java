import java.util.LinkedList;

import tracker.*;

public class Test{

	static int score = 0;

    public static void main(String[] args) {
    
        testLabel();
        testIssue();
        testTracker();
        
		System.out.println("Pontszam: " + score);

		if(score < 6) System.out.println("Jegy: elegtelen (1)");
		else if(score < 9) System.out.println("Jegy: elegseges (2)");
		else if(score < 12) System.out.println("Jegy: kozepes (3)");
		else if(score < 15) System.out.println("Jegy: jo (4)");
		else System.out.println("Jegy: jeles (5)");

    }

    private static void testLabel() {
    
        Label l1 = new Label("alma");
        String s = new String("alma");
        Label l2 = new Label(s);
        Label l3 = new Label("korte");
    
        assertEquals("A Label osztaly konstruktora vagy lekerdezo-muvelete helytelenul mukodik.", l1.getName(), s);
        assertEquals("A Label osztaly konstruktora vagy lekerdezo-muvelete helytelenul mukodik.", l2.getName(), "alma");
        
        score = score + 1;
        
        assertTrue("A Label osztaly isSame muvelete egyforma cimkeknel hamisat adott vissza.", l1.isSame(l2));
        assertTrue("A Label osztaly isSame muvelete egyforma cimkeknel hamisat adott vissza.", l2.isSame(l1));
        assertTrue("A Label osztaly isSame muvelete kulonbozo cimkeknel igazat adott vissza.", !l2.isSame(l3));
        
        score = score + 1;
        
        System.out.println("Label: OK (eddig " + score + " pont)");
        
    }
    
    private static void testIssue() {
        
        testIssueConstructorAndGetters();
        testIssueCreate();
        testIssueHasLabel();

        System.out.println("Issue: OK (eddig " + score + " pont)");
        
    }
    
    private static void testIssueConstructorAndGetters() {
    
        Label l1 = new Label("alma");
        Label l2 = new Label("korte");
        Label l3 = new Label("szilva");
        Label[] labels = new Label[] { l1, l2, l3 };
        Issue i1 = new Issue("gyumolcsok", labels, 42);
        
        assertEquals("Az Issue osztaly konstruktora vagy lekerdezo-muvelete helytelenul mukodik.", i1.getDescription(), "gyumolcsok");
        assertEquals("Az Issue osztaly konstruktora vagy lekerdezo-muvelete helytelenul mukodik.", i1.getMilestone(), 42);
        assertEquals("Az Issue osztaly konstruktora vagy lekerdezo-muvelete helytelenul mukodik.", i1.getLabels().size(), 3);
        assertTrue("Az Issue osztaly konstruktora vagy lekerdezo-muvelete helytelenul mukodik.", i1.getLabels().get(1).isSame(l2));
        
        score = score + 2;
        
    }

    private static void testIssueCreate() {
    
        Issue i1 = Issue.createIssue("");
        Issue i2 = Issue.createIssue("alma");
        Issue i3 = Issue.createIssue("alma:korte");
        Issue i4 = Issue.createIssue("alma:42:2");
        Issue i5 = Issue.createIssue("alma@korte@barack:42");
        Issue i6 = Issue.createIssue("alma@joska:42:2");
        Issue i7 = Issue.createIssue("alma@joska:korte");
        
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"\").", (i1 == null));
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"alma\").", (i2 == null));
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"alma:korte\").", (i3 == null));
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"alma:42:2\").", (i4 == null));
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"alma@korte@barack:42\").", (i5 == null));
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"alma@joska:42:2\").", (i6 == null));
        assertTrue("A createIssue metodus helytelen inputra is letrehoz objektumot (\"alma@joska:korte\").", (i7 == null));
        
        Issue i8 = Issue.createIssue("alma:42");
        Issue i9 = Issue.createIssue("alma@joska:42");
        Issue i10 = Issue.createIssue("alma@joska,pista:42");
        
        assertTrue("A createIssue metodus helyes inputra nem letrehoz objektumot (\"alma:42\").", (i8 != null));
        assertTrue("A createIssue metodus helyes inputra nem letrehoz objektumot (\"alma@joska:42\").", (i9 != null));
        assertTrue("A createIssue metodus helyes inputra nem letrehoz objektumot (\"alma@joska,pista:42\").", (i10 != null));
        
        assertEquals("A createIssue metodus helytelen objektumot hoz letre (\"alma:42\").", i8.getDescription(), "alma");
        assertEquals("A createIssue metodus helytelen objektumot hoz letre (\"alma:42\").", i8.getMilestone(), 42);
        assertEquals("A createIssue metodus helytelen objektumot hoz letre (\"alma@joska,pista:42\").", i10.getMilestone(), 42);
        assertEquals("A createIssue metodus helytelen objektumot hoz letre (\"alma:42\").", i8.getLabels().size(), 0);
        assertEquals("A createIssue metodus helytelen objektumot hoz letre (\"alma@joska,pista:42\").", i10.getLabels().size(), 2);
        assertEquals("A createIssue metodus helytelen objektumot hoz letre (\"alma@joska,pista:42\").", i10.getLabels().get(1).getName(), "pista");
        
        score = score + 2;
    }
    
    private static void testIssueHasLabel() {
    
        Issue i1 = Issue.createIssue("alma:42");
        Issue i2 = Issue.createIssue("alma@joska,pista:42");
        
        assertFalse("A Issue osztaly hasLabel metodusa helytelenul mukodik (i1.hasLabel(\"proba\")).", i1.hasLabel("proba"));
        assertTrue("A Issue osztaly hasLabel metodusa helytelenul mukodik (i2.hasLabel(\"joska\")).", i2.hasLabel("joska"));
        assertTrue("A Issue osztaly hasLabel metodusa helytelenul mukodik (i2.hasLabel(\"pista\")).", i2.hasLabel("pista"));
        assertFalse("A Issue osztaly hasLabel metodusa helytelenul mukodik(i2.hasLabel(\"proba\")).", i2.hasLabel("proba"));
        
        score = score + 1;
    }

    private static boolean labelListEquals(LinkedList<Label> l1, LinkedList<Label> l2) {
        if( (l1 == null) && (l2 == null) ) return true;
        if( ((l1 != null) && (l2 == null)) || ((l1 == null) && (l2 != null)) ) return false;
        if( l1.size() != l2.size() ) return false;

        for(int i = 0; i < l1.size(); i++) {
            if( !l1.get(i).isSame(l2.get(i)) )
                return false;
        }
        
        return true;
    }
        
    private static boolean issueEquals(Issue i1, Issue i2) {
        return ((i1.getDescription().equals(i2.getDescription())) &&
                (labelListEquals(i1.getLabels(), i2.getLabels())) &&
                (i1.getMilestone() == i2.getMilestone()));
    }
    
    private static boolean issueListEquals(LinkedList<Issue> l1, LinkedList<Issue> l2) {
        if( (l1 == null) && (l2 == null) ) return true;
        if( ((l1 != null) && (l2 == null)) || ((l1 == null) && (l2 != null)) ) return false;
        if( l1.size() != l2.size() ) return false;

        for(int i = 0; i < l1.size(); i++) {
            if( !issueEquals(l1.get(i), l2.get(i)) )
                return false;
        }
        
        return true;
    }
    
    private static void testTracker() {
        
        Tracker t = new Tracker("input.txt");
        
        assertEquals("A Tracker osztaly konstruktora helytelenul mukodik.", t.getNumberOfLabels(), 4);
        assertEquals("A Tracker osztaly konstruktora helytelenul mukodik.", t.getNumberOfIssues(), 4);
        
        score = score + 4;
        
        assertTrue("A Tracker osztaly find metodusa helytelenul mukodik (d1-re-re a masodik sort kene visszaadnia).", issueEquals(t.find("d1"), Issue.createIssue("d1@lab1,lab2,lab3:2")));
        assertTrue("A Tracker osztaly find metodusa helytelenul mukodik (d5-re nem kene talalatot adnia, mert az utolo sor ervenytelen, mert nincs lab4-es label).", (t.find("d5") == null));
        
        score = score + 2;
        
        LinkedList<Issue> l = new LinkedList<Issue>();
        l.add(Issue.createIssue("d1@lab1,lab2,lab3:2"));
        l.add(Issue.createIssue("d2@lab2,lab3:3"));
        assertTrue("A Tracker osztaly listByLabel metodusa helytelenul mukodik (lab2-re az elso ket feladatot kene visszaadnia).", issueListEquals(t.listByLabel(new Label("lab2")), l));
        assertEquals("A Tracker osztaly listByLabel metodusa helytelenul mukodik (lab5-re ures listat kene visszaadnia).", t.listByLabel(new Label("lab5")).size(), 0);
        assertTrue("A Tracker osztaly listByLabel metodusa helytelenul mukodik (lab4-re null- kene visszaadnia).", (t.listByLabel(new Label("lab4")) == null));
        
        score = score + 2;

        assertTrue("A Tracker osztaly isMilestoneComplete metodusa helytelenul mukodik (1-re igazat kene visszaadnia).", t.isMilestoneComplete(1));
        assertFalse("A Tracker osztaly isMilestoneComplete metodusa helytelenul mukodik (2-re hamisat kene visszaadnia).", t.isMilestoneComplete(2));
        
        score = score + 2;
        
        System.out.println("Tracker: OK (eddig " + score + " pont)");

    }
    
	private static void assertFalse(String msg, boolean p) {
		if (p) {
			throw new RuntimeException(msg);
		}
	}

	private static void assertTrue(String msg, boolean p) {
		if (!p) {
			throw new RuntimeException(msg);
		}
	}

	private static void assertEquals(String msg, Object expected, Object actual) {
		if (!expected.equals(actual)) {
			throw new RuntimeException(msg + "\nexpected:\n" + expected
					+ "\nactual:\n" + actual);
		}
	}
    
}