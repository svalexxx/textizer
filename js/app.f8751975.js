(function(){"use strict";var e={5372:function(e,t,n){var o=n(5130),r=n(6768);const a={id:"app"};function i(e,t,n,o,i,s){const u=(0,r.g2)("router-view");return(0,r.uX)(),(0,r.CE)("div",a,[(0,r.bF)(u)])}var s={name:"App"},u=n(1241);const c=(0,u.A)(s,[["render",i]]);var l=c,d=n(1387),p=n(4232);const h={class:"login-container"},f={key:0,class:"error"};function g(e,t,n,a,i,s){return(0,r.uX)(),(0,r.CE)("div",h,[t[6]||(t[6]=(0,r.Lk)("h2",null,"Login",-1)),(0,r.Lk)("form",{onSubmit:t[2]||(t[2]=(0,o.D$)(((...e)=>s.login&&s.login(...e)),["prevent"]))},[(0,r.Lk)("div",null,[t[3]||(t[3]=(0,r.Lk)("label",{for:"username"},"Username:",-1)),(0,r.bo)((0,r.Lk)("input",{"onUpdate:modelValue":t[0]||(t[0]=e=>i.username=e),id:"username",type:"text",required:""},null,512),[[o.Jo,i.username]])]),(0,r.Lk)("div",null,[t[4]||(t[4]=(0,r.Lk)("label",{for:"password"},"Password:",-1)),(0,r.bo)((0,r.Lk)("input",{"onUpdate:modelValue":t[1]||(t[1]=e=>i.password=e),id:"password",type:"password",required:""},null,512),[[o.Jo,i.password]])]),t[5]||(t[5]=(0,r.Lk)("button",{type:"submit"},"Login",-1))],32),i.errorMessage?((0,r.uX)(),(0,r.CE)("p",f,(0,p.v_)(i.errorMessage),1)):(0,r.Q3)("",!0)])}n(4114),n(4979);var v=n(4373),m={data(){return{username:"",password:"",errorMessage:""}},methods:{async login(){try{const e="Basic "+btoa(`${this.username}:${this.password}`);localStorage.setItem("authToken",e),await v.A.get(`${{NODE_ENV:"production",BASE_URL:"/"}.VUE_APP_BACKEND_URL||"http://localhost:8888"}/api/content`,{headers:{Authorization:e}}),this.$router.push("/content")}catch(e){console.error("Login failed:",e),this.errorMessage="Invalid username or password."}}}};const b=(0,u.A)(m,[["render",g],["__scopeId","data-v-41e2c155"]]);var y=b;const k={key:0},L={key:1},E={key:3,class:"error"};function _(e,t,n,o,a,i){return(0,r.uX)(),(0,r.CE)("div",null,[t[2]||(t[2]=(0,r.Lk)("h1",null,"Content List",-1)),a.loading?((0,r.uX)(),(0,r.CE)("div",k,"Loading...")):((0,r.uX)(),(0,r.CE)("ul",L,[((0,r.uX)(!0),(0,r.CE)(r.FK,null,(0,r.pI)(a.content,(e=>((0,r.uX)(),(0,r.CE)("li",{key:e.id},[(0,r.Lk)("h2",null,(0,p.v_)(e.title),1),(0,r.Lk)("p",null,(0,p.v_)(e.mainText),1),(0,r.Lk)("p",null,[t[1]||(t[1]=(0,r.Lk)("strong",null,"Author:",-1)),(0,r.eW)(" "+(0,p.v_)(e.author),1)])])))),128))])),a.hasNext?((0,r.uX)(),(0,r.CE)("button",{key:2,onClick:t[0]||(t[0]=(...e)=>i.loadMore&&i.loadMore(...e))},"Load More")):(0,r.Q3)("",!0),a.errorMessage?((0,r.uX)(),(0,r.CE)("p",E,(0,p.v_)(a.errorMessage),1)):(0,r.Q3)("",!0)])}var w={data(){return{content:[],page:0,size:30,hasNext:!1,loading:!1,errorMessage:""}},methods:{async fetchContent(){this.loading=!0,this.errorMessage="";try{const e=localStorage.getItem("authToken"),t={NODE_ENV:"production",BASE_URL:"/"}.VUE_APP_BACKEND_URL||"http://localhost:8888",n=await v.A.get(`${t}/api/content`,{params:{page:this.page,size:this.size},headers:{Authorization:e}});this.content=[...this.content,...n.data.content],this.hasNext=n.data.hasNext}catch(e){console.error("Error fetching content:",e),this.errorMessage="Failed to fetch content. Please try again."}finally{this.loading=!1}},loadMore(){this.page+=1,this.fetchContent()}},mounted(){this.fetchContent()}};const C=(0,u.A)(w,[["render",_],["__scopeId","data-v-b3cccbee"]]);var A=C;const M=[{path:"/",redirect:"/login"},{path:"/login",name:"Login",component:y},{path:"/content",name:"Content",component:A}],O=(0,d.aE)({history:(0,d.LA)(),routes:M});var x=O;(0,o.Ef)(l).use(x).mount("#app")}},t={};function n(o){var r=t[o];if(void 0!==r)return r.exports;var a=t[o]={exports:{}};return e[o].call(a.exports,a,a.exports,n),a.exports}n.m=e,function(){var e=[];n.O=function(t,o,r,a){if(!o){var i=1/0;for(l=0;l<e.length;l++){o=e[l][0],r=e[l][1],a=e[l][2];for(var s=!0,u=0;u<o.length;u++)(!1&a||i>=a)&&Object.keys(n.O).every((function(e){return n.O[e](o[u])}))?o.splice(u--,1):(s=!1,a<i&&(i=a));if(s){e.splice(l--,1);var c=r();void 0!==c&&(t=c)}}return t}a=a||0;for(var l=e.length;l>0&&e[l-1][2]>a;l--)e[l]=e[l-1];e[l]=[o,r,a]}}(),function(){n.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return n.d(t,{a:t}),t}}(),function(){n.d=function(e,t){for(var o in t)n.o(t,o)&&!n.o(e,o)&&Object.defineProperty(e,o,{enumerable:!0,get:t[o]})}}(),function(){n.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){n.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)}}(),function(){n.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})}}(),function(){var e={524:0};n.O.j=function(t){return 0===e[t]};var t=function(t,o){var r,a,i=o[0],s=o[1],u=o[2],c=0;if(i.some((function(t){return 0!==e[t]}))){for(r in s)n.o(s,r)&&(n.m[r]=s[r]);if(u)var l=u(n)}for(t&&t(o);c<i.length;c++)a=i[c],n.o(e,a)&&e[a]&&e[a][0](),e[a]=0;return n.O(l)},o=self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[];o.forEach(t.bind(null,0)),o.push=t.bind(null,o.push.bind(o))}();var o=n.O(void 0,[504],(function(){return n(5372)}));o=n.O(o)})();
//# sourceMappingURL=app.f8751975.js.map