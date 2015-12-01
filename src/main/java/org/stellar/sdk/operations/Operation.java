package org.stellar.sdk.operations;

import com.google.gson.annotations.SerializedName;

import org.stellar.base.Keypair;
import org.stellar.sdk.Link;

/**
 * Abstract class for operation responses.
 */
public abstract class Operation {
  @SerializedName("id")
  protected Long id;
  @SerializedName("source_account")
  protected Keypair sourceAccount;
  @SerializedName("type")
  protected String type;
  @SerializedName("_links")
  private Links links;

  public Long getId() {
    return id;
  }

  public Keypair getSourceAccount() {
    return sourceAccount;
  }

  /**
   * <p>Returns operation type. Possible types:</p>
   * <ul>
   *   <li>create_account</li>
   *   <li>payment</li>
   *   <li>allow_trust</li>
   *   <li>change_trust</li>
   *   <li>set_options</li>
   *   <li>account_merge</li>
   *   <li>manage_offer</li>
   *   <li>path_payment</li>
   *   <li>create_passive_offer</li>
   *   <li>inflation</li>
   * </ul>
   */
  public String getType() {
    return type;
  }

  public Links getLinks() {
    return links;
  }

  /**
   * Represents operation links
   */
  public static class Links {
    @SerializedName("effects")
    private final Link effects;
    @SerializedName("precedes")
    private final Link precedes;
    @SerializedName("self")
    private final Link self;
    @SerializedName("succeeds")
    private final Link succeeds;
    @SerializedName("transaction")
    private final Link transaction;

    public Links(Link effects, Link precedes, Link self, Link succeeds, Link transaction) {
      this.effects = effects;
      this.precedes = precedes;
      this.self = self;
      this.succeeds = succeeds;
      this.transaction = transaction;
    }

    public Link getEffects() {
      return effects;
    }

    public Link getPrecedes() {
      return precedes;
    }

    public Link getSelf() {
      return self;
    }

    public Link getSucceeds() {
      return succeeds;
    }

    public Link getTransaction() {
      return transaction;
    }
  }
}