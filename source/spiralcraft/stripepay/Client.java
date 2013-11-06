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
  
  { Stripe.apiKey="sk_test_mkGsLqEW6SLnZa487HYfJVLf";
  }
  
  public void setApiKey(String apiKey)
  { Stripe.apiKey=apiKey;
  }
}
