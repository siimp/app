(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-9edfbede"],{6054:function(e,t,a){"use strict";var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("select",{directives:[{name:"show",rawName:"v-show",value:e.isDataLoaded,expression:"isDataLoaded"}],domProps:{value:e.value},on:{input:function(t){return e.$emit("input",t.target.value)}}},[e.isDataLoaded?e._e():a("option",[e._v("loading countries")]),e.isDataLoaded?a("option",{attrs:{value:""}},[e._v("Choose...")]):e._e(),e._l(e.countries,function(t){return a("option",{key:t.id,domProps:{value:t.id}},[e._v(e._s(t.name))])})],2)},r=[],o=a("9ab4"),i=a("60a3"),n=a("2f62"),l=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return o["c"](t,e),t.prototype.mounted=function(){var e=this,t=this.loadCountries();t.then(function(){e.isDataLoaded=!0})},t.prototype.data=function(){return{isDataLoaded:!1}},t=o["b"]([Object(i["a"])({computed:o["a"]({},Object(n["c"])(["countries"])),methods:o["a"]({},Object(n["b"])(["loadCountries"])),props:["value"]})],t),t}(i["b"]),d=l,c=d,u=a("2877"),m=Object(u["a"])(c,s,r,!1,null,null,null);t["a"]=m.exports},e94a:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return e.user.id?a("div",{staticClass:"container"},[e._m(0),a("div",{staticClass:"row"},[a("div",{staticClass:"col-md-12 order-md-1"},[a("form",{staticClass:"needs-validation",attrs:{novalidate:""},on:{submit:function(t){return t.preventDefault(),e.addClient(t)}}},[a("div",{staticClass:"row"},[a("div",{staticClass:"col-md-6 mb-3"},[a("label",{attrs:{for:"firstName"}},[e._v("First name")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.firstName,expression:"form.firstName"}],staticClass:"form-control",class:{"is-invalid":!!e.errors.firstName},attrs:{type:"text",id:"firstName",placeholder:"",value:""},domProps:{value:e.form.firstName},on:{input:function(t){t.target.composing||e.$set(e.form,"firstName",t.target.value)}}}),e.errors.firstName?a("div",{staticClass:"invalid-feedback"},[e._v("\n                  "+e._s(e.errors.firstName.defaultMessage)+"\n                ")]):e._e()]),a("div",{staticClass:"col-md-6 mb-3"},[a("label",{attrs:{for:"lastName"}},[e._v("Last name")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.lastName,expression:"form.lastName"}],staticClass:"form-control",class:{"is-invalid":!!e.errors.lastName},attrs:{type:"text",id:"lastName",placeholder:"",value:""},domProps:{value:e.form.lastName},on:{input:function(t){t.target.composing||e.$set(e.form,"lastName",t.target.value)}}}),e.errors.lastName?a("div",{staticClass:"invalid-feedback"},[e._v("\n                  "+e._s(e.errors.lastName.defaultMessage)+"\n                ")]):e._e()])]),a("div",{staticClass:"mb-3"},[a("label",{attrs:{for:"username"}},[e._v("Username")]),a("div",{staticClass:"input-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.username,expression:"form.username"}],staticClass:"form-control",class:{"is-invalid":!!e.errors.username},attrs:{type:"text",id:"username",placeholder:"Username"},domProps:{value:e.form.username},on:{input:function(t){t.target.composing||e.$set(e.form,"username",t.target.value)}}}),e.errors.username?a("div",{staticClass:"invalid-feedback"},[e._v("\n                  "+e._s(e.errors.username.defaultMessage)+"\n                ")]):e._e()])]),a("div",{staticClass:"mb-3"},[e._m(1),a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.email,expression:"form.email"}],staticClass:"form-control",class:{"is-invalid":!!e.errors.email},attrs:{type:"email",id:"email",placeholder:"you@example.com"},domProps:{value:e.form.email},on:{input:function(t){t.target.composing||e.$set(e.form,"email",t.target.value)}}}),e.errors.email?a("div",{staticClass:"invalid-feedback"},[e._v("\n                  "+e._s(e.errors.email.defaultMessage)+"\n              ")]):e._e()]),a("div",{staticClass:"mb-3"},[a("label",{attrs:{for:"address"}},[e._v("Address")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.address,expression:"form.address"}],staticClass:"form-control",class:{"is-invalid":!!e.errors.address},attrs:{type:"text",id:"address",placeholder:"1234 Main St"},domProps:{value:e.form.address},on:{input:function(t){t.target.composing||e.$set(e.form,"address",t.target.value)}}}),e.errors.address?a("div",{staticClass:"invalid-feedback"},[e._v("\n                "+e._s(e.errors.address.defaultMessage)+"\n              ")]):e._e()]),a("div",{staticClass:"mb-3"},[a("label",{attrs:{for:"country"}},[e._v("Country")]),a("CountrySelect",{staticClass:"custom-select d-block w-100",class:{"is-invalid":!!e.errors.country},attrs:{id:"country"},model:{value:e.form.country,callback:function(t){e.$set(e.form,"country",t)},expression:"form.country"}}),e.errors.country?a("div",{staticClass:"invalid-feedback"},[e._v("\n                  "+e._s(e.errors.country.defaultMessage)+"\n                ")]):e._e()],1),a("hr",{staticClass:"mb-4"}),a("button",{staticClass:"btn btn-primary btn-lg btn-block",attrs:{type:"submit"}},[e._v("Add Client")])])])])]):e._e()},r=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"py-5 text-center"},[a("h2",[e._v("Add Client")])])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("label",{attrs:{for:"email"}},[e._v("Email "),a("span",{staticClass:"text-muted"},[e._v("(Optional)")])])}],o=a("9ab4"),i=a("60a3"),n=a("bc3a"),l=a.n(n),d=a("6054"),c=a("a504"),u=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return o["c"](t,e),t.prototype.addClient=function(){var e=this,t=this.user;l.a.post(this.API_URL+"/user/"+t.id+"/client",this.form).then(function(t){e.$router.push("/")}).catch(function(t){var a={};t.response.data&&Array.isArray(t.response.data.errors)&&(t.response.data.errors.forEach(function(e){a[e.field]={defaultMessage:e.defaultMessage}}),e.errors=a)})},t.prototype.data=function(){return{form:{},errors:{}}},t=o["b"]([Object(i["a"])({components:{CountrySelect:d["a"]}})],t),t}(c["a"]),m=u,f=m,v=a("2877"),p=Object(v["a"])(f,s,r,!1,null,null,null);t["default"]=p.exports}}]);
//# sourceMappingURL=chunk-9edfbede.a5a4718f.js.map