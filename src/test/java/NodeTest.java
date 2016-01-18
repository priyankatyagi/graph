import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class NodeTest {

    private Node a;
    private Node b;
    private Node c;
    private Node d;
    private Node e;
    private Node f;
    private Node g;
    private Node h;

    @Before
    public void setUp() throws Exception {
        a = new Node("a");
        b = new Node("b");
        c = new Node("c");
        d = new Node("d");
        e = new Node("e");
        f = new Node("f");
        g = new Node("g");
        h = new Node("h");

        a.connectTo(f);
        b.connectTo(c);
        b.connectTo(a);
        c.connectTo(d);
        c.connectTo(e);
        d.connectTo(e);
        e.connectTo(b);
        h.connectTo(b);
    }

    @Test
    public void aCanReachA(){
        assertTrue(a.canReach(a));
    }

    @Test
    public void aCanReachF() throws Exception {
      assertTrue(a.canReach(f));
    }

    @Test
    public void hCanReachC() throws Exception {
        assertTrue(h.canReach(c));
    }

    @Test
    public void dCanReachC() throws Exception {
        assertTrue(c.canReach(d));
    }

    @Test
    public void aReachesAin0Hops() throws Exception {
        assertEquals(0,a.hopsTo(a));
    }

    @Test
    public void hReachesBin1Hop() throws Exception {
        assertEquals(1,h.hopsTo(b));
    }

    @Test
    public void hReachesCin2Hops() throws Exception {
        assertEquals(2,h.hopsTo(c));
    }

    @Test
    public void cReachesBin2Hops() throws Exception {
        assertEquals(2,c.hopsTo(b));
    }

    @Test
    public void hReachesGinInfiniteHops() throws Exception {
        assertEquals(Integer.MAX_VALUE,h.hopsTo(g));

    }
    @Test
    public void hReachesEin3Hops() throws Exception {
        assertEquals(3,h.hopsTo(e));

    }
    @Test
    public void hReachesEisn3Hops() throws Exception {
        assertEquals(3,h.hopsTo(d));

    }
}
