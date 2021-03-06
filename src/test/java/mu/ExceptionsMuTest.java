package mu;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UncheckedIOException;

import static org.junit.Assert.*;

public class ExceptionsMuTest {

  @Test
  public void testAsUncheckedRuntimeException() throws Exception {
    final RuntimeException e = new RuntimeException();
    Assert.assertEquals(e, ExceptionsMu.asUnchecked(e));
  }

  @Test
  public void testAsUncheckedThrowable() throws Exception {
    Assert.assertTrue(ExceptionsMu.asUnchecked(new Throwable()) instanceof RuntimeException);
  }

  @Test
  public void testAsUncheckedIO() throws Exception {
    Assert.assertTrue(ExceptionsMu.asUnchecked(new IOException()) instanceof UncheckedIOException);
  }

  @Test(expected = Error.class)
  public void testAsUncheckedError() throws Exception {
    final Error e = new Error();
    ExceptionsMu.asUnchecked(e);
  }

  @Test
  public void testGetRootCause() throws Exception {
    final RuntimeException cause = new RuntimeException();
    Assert.assertEquals(cause, ExceptionsMu.getRootCause(new RuntimeException(cause)));
  }

  @Test
  public void testGetRootCauseWithNullCause() throws Exception {
    final RuntimeException e = new RuntimeException();
    Assert.assertEquals(e, ExceptionsMu.getRootCause(e));
  }

  @Test
  public void testGetStackTrace() throws Exception {
    Assert.assertNotNull(ExceptionsMu.getStackTrace(new RuntimeException()));
  }

  @Test
  public void testGetRootCauseMessage() throws Exception {
    String message = "message";
    final RuntimeException cause = new RuntimeException(message);
    Assert.assertEquals(message, ExceptionsMu.getRootCauseMessage(new RuntimeException(cause)));
  }

}