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

import com.stripe.Stripe;

/**
 * Expose the Stripe API to Spiralcraft apps
 * 
 * @author mike
 *
 */
public class Client
{
  
  private String publicKey="pk_test_9e1WmEpACLsRINTG81ZF5BuE";
  
  { Stripe.apiKey="sk_test_QdRyG6Csd1GwKr9h26h70uhd";
  }

  public void setSecretKey(String secretKey)
  { Stripe.apiKey=secretKey;
  }
  
  public String getSecretKey()
  { return Stripe.apiKey;
  }
  
  public void setPublicKey(String publicKey)
  { this.publicKey=publicKey;
  }
  
  public String getPublicKey()
  { return publicKey;
  }
      
}
