
/*
If a user resets their password a hundred times, and each time it's added to the customer document, pulling information
about that customer for a simple action (like a login) will be very resource-intensive.
It's better to separate out events that can be repeated many times, like orders, site visits, and password resets into
their own collection, and use document references to link other collections.
 */

package com.digishop.mutableuserinfo.impl;