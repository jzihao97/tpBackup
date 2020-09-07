// import details from './moduleInfo.js';
// import list from './moduleList.js';

const details = require('./moduleInfo.js');
const list = require('./moduleList.js');

var templateObj = {
  moduleCode: "",
  title: "",
  description: "",
  moduleCredit: "",
  department: "",
  faculty: "",
  workload: "",
  semesterData: {
    semester: "",
    examDate: "",
    examDuration: "",
  },
  preclusion: "",
  typeData: {
    su: "",
    sfs: "",
    ssgf: "",
    ism: "",
    fyp: "",
    year: "",
    grsu: "",
    lab: "",
    urop: "",
  },
  prerequisite: "",
  corequisite: "",
}

console.log("this is the length of the list: " + list.length);
console.log("this is the length of details: " + details.length);

// for (var i = 0; i < list.length )