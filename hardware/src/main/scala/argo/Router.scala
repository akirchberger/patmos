/*
   Copyright 2013 Technical University of Denmark, DTU Compute.
   All rights reserved.

   This file is part of the time-predictable VLIW processor Patmos.

   Redistribution and use in source and binary forms, with or without
   modification, are permitted provided that the following conditions are met:

      1. Redistributions of source code must retain the above copyright notice,
         this list of conditions and the following disclaimer.

      2. Redistributions in binary form must reproduce the above copyright
         notice, this list of conditions and the following disclaimer in the
         documentation and/or other materials provided with the distribution.

   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER ``AS IS'' AND ANY EXPRESS
   OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
   OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN
   NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY
   DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
   THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

   The views and conclusions contained in the software and documentation are
   those of the authors and should not be interpreted as representing official
   policies, either expressed or implied, of the copyright holder.
 */

/*
 * A synchronous Argo router
 *
 * Authors: Rasmus Bo Soerensen (rasmus@rbscloud.dk)
 *
 */

package argo

import Chisel._
import Node._

class Router(argoConf: ArgoConfig) extends Module() {
  val io = new Bundle() {
    val northPort = new RouterPort(argoConf)
    val southPort = new RouterPort(argoConf)
    val eastPort = new RouterPort(argoConf)
    val westPort = new RouterPort(argoConf)
    val localPort = new RouterPort(argoConf)
  }


  val xbar = Module(new XBar(argoConf.LINK_WIDTH))
  val northHPU = Module(new HPU("North",argoConf.LINK_WIDTH))
  val southHPU = Module(new HPU("South",argoConf.LINK_WIDTH))
  val eastHPU = Module(new HPU("East",argoConf.LINK_WIDTH))
  val westHPU = Module(new HPU("West",argoConf.LINK_WIDTH))
  val localHPU = Module(new HPU("Local",argoConf.LINK_WIDTH))

//  northHPU.io.inLink := io.northPort.in
//  southHPU.io.inLink := io.southPort.in
//  eastHPU.io.inLink := io.eastPort.in
//  westHPU.io.inLink := io.westPort.in
//  localHPU.io.inLink := io.localPort.in
//
//  io.northPort.out := xbar.io.northOut
//  io.southPort.out := xbar.io.southOut
//  io.eastPort.out := xbar.io.eastOut
//  io.westPort.out := xbar.io.westOut
//  io.localPort.out := xbar.io.localOut

}
