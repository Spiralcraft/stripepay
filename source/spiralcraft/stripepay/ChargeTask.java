//
//Copyright (c) 2013 Michael Toth
//Spiralcraft Inc., All Rights Reserved
//
//This package is part of the Spiralcraft project and is licensed under
//a multiple-license framework.
//
//You may not use this file except in compliance with the terms found in the
//SPIRALCRAFT-LICENSE.txt file at the top of this distribution, or available
//at http://www.spiralcraft.org/licensing/SPIRALCRAFT-LICENSE.txt.
//
//Unless otherwise agreed to in writing, this software is distributed on an
//"AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.
//

package spiralcraft.stripepay;

import spiralcraft.log.Level;
import spiralcraft.task.AbstractTask;

import java.math.BigDecimal;
import java.util.HashMap;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
/**
 * A Charge to send to Stripe for auth/capture
 * 
 * @author mike
 *
 */
public class ChargeTask
  extends AbstractTask
{
  
  private BigDecimal amount;
  private String currency="usd";
  private String card;
  private String description;
  private String refId;
  private String paymentId;
  private Charge charge;
  
  
  public void setAmount(BigDecimal amount)
  { this.amount=amount;
  }
  
  public void setCurrency(String currency)
  { this.currency=currency;
  }
  
  public void setCard(String card)
  { this.card=card;
  }
  
  public void setDescription(String description)
  { this.description=description;
  }
  
  public void setRefId(String refId)
  { this.refId=refId;
  }
  
  public void setPaymentId(String paymentId)
  { this.paymentId=paymentId;
  }
  
    
  @Override
  public void work()
  {
    try
    {
      if (amount==null)
      { throw new IllegalArgumentException("Amount cannot be null");
      }
      if (card==null)
      { throw new IllegalArgumentException("Card cannot be null");
      }
      
    }
    catch (Exception x)
    { 
      addException(x);
      log.log(Level.SEVERE,"Caught exception processing card",x);
      return;
    }
    
    HashMap<String, Object> chargeParams 
      = new HashMap<String, Object>(); 
    chargeParams.put("amount", amount.multiply(BigDecimal.valueOf(100)).intValue());
    chargeParams.put("currency", currency); 
    chargeParams.put("card", card); 
    chargeParams.put("description", description); 
      
    HashMap<String,Object> metadata
      =new HashMap<String,Object>();
    metadata.put("refId",refId);
    metadata.put("paymentId",paymentId);
    chargeParams.put("metadata", metadata); 
      
      
    try
    {
      charge=com.stripe.model.Charge.create(chargeParams);
      log.fine(charge.toString());
      addResult(charge);
    }
    catch (APIException x)
    { 
      addException(x);
      log.log(Level.SEVERE,"Caught exception processing card",x);
    }
    catch (AuthenticationException x)
    {
      addException(x);
      log.log(Level.SEVERE,"Caught exception processing card",x);
    }
    catch (InvalidRequestException x)
    {
      addException(x);
      log.log(Level.SEVERE,"Caught exception processing card",x);
    }
    catch (APIConnectionException x)
    {
      addException(x);
      log.log(Level.SEVERE,"Caught exception processing card",x);
    }
    catch (CardException x)
    {
      addException(x);
      log.log(Level.SEVERE,"Caught exception processing card",x);
    }
     
  }
  
  public Charge getCharge()
  { return charge;
  }
  
}
